<template>
  <section class="py-6 px-4 bg-green-50">
    <h2 class="text-2xl font-bold mb-4 text-green-800">Featured Produce</h2>

    <div class="relative">
      <!-- Keen Slider -->
      <div ref="sliderRef" class="keen-slider">
        <div
          v-for="product in products"
          :key="product.id"
          class="keen-slider__slide"
        >
          <div @click="openModal(product)">
            <Card :product="product" />
          </div>
        </div>
      </div>

      <!-- Modal -->
      <Modal
        v-if="selectedProduct"
        :product="selectedProduct"
        @close="selectedProduct = null"
      />

      <!-- Navigation Arrows -->
      <button
        @click="sliderInstance?.prev()"
        class="absolute left-0 top-1/2 -translate-y-1/2 bg-white border shadow rounded-full p-2 z-10 hover:bg-green-100"
      >
        ◀
      </button>
      <button
        @click="sliderInstance?.next()"
        class="absolute right-0 top-1/2 -translate-y-1/2 bg-white border shadow rounded-full p-2 z-10 hover:bg-green-100"
      >
        ▶
      </button>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useKeenSlider } from 'keen-slider/vue'
import Card from '@/components/Card.vue'
import Modal from '@/components/ProductModal.vue'

const products = ref([])
const selectedProduct = ref(null)

const sliderRef = ref()
const [sliderInstance] = useKeenSlider(sliderRef, {
  loop: true,
  slides: {
    perView: 3,
    spacing: 24,
  },
  breakpoints: {
    '(min-width: 640px)': {
      slides: { perView: 2.5, spacing: 24 },
    },
    '(min-width: 1024px)': {
      slides: { perView: 4, spacing: 28 },
    },
  },
})

const openModal = (product) => {
  selectedProduct.value = product
}

onMounted(async () => {
  try {
    const res = await fetch('https://localhost:8443/api/products')
    products.value = await res.json()
  } catch (error) {
    console.error('Failed to fetch products:', error)
  }
})
</script>
